# ER-модель AgroTechCare

Версия 1 — модель данных для этапов 1–3 roadmap: клиенты, техника, договоры, заказ-наряды.
Технические таблицы интеграции с 1С (outbox/inbox) появятся на этапе 4 и здесь не описаны.

## Диаграмма

```mermaid
erDiagram
    CLIENTS ||--o{ USERS : "контактные лица"
    CLIENTS ||--o{ CONTRACTS : "заключает"
    CLIENTS ||--o{ MACHINES : "владеет"
    CLIENTS ||--o{ WORK_ORDERS : "заказчик"
    BRANDS ||--o{ MACHINE_MODELS : ""
    MACHINE_MODELS ||--o{ MACHINES : ""
    CONTRACTS ||--o{ CONTRACT_MACHINES : ""
    MACHINES ||--o{ CONTRACT_MACHINES : ""
    MACHINES ||--o{ WORK_ORDERS : "ремонтируется"
    CONTRACTS |o--o{ WORK_ORDERS : "основание"
    USERS ||--o{ WORK_ORDERS : "создал"
    WORK_ORDERS ||--o{ WORK_ORDER_MECHANICS : ""
    USERS ||--o{ WORK_ORDER_MECHANICS : "механик"
    WORK_ORDERS ||--o{ WORK_ORDER_STATUS_HISTORY : ""
    WORK_ORDERS ||--o{ WORK_ORDER_JOBS : "ТЧ работы"
    JOBS ||--o{ WORK_ORDER_JOBS : ""
    WORK_ORDERS ||--o{ WORK_ORDER_PARTS : "ТЧ запчасти"
    PARTS ||--o{ WORK_ORDER_PARTS : ""

    CLIENTS {
        bigint id PK
        varchar type "LEGAL | INDIVIDUAL"
        varchar name
        varchar unp "УНП, только у юрлица"
        varchar address
        varchar phone
        varchar email
    }
    USERS {
        bigint id PK
        bigint client_id FK "NULL у сотрудников"
        varchar username UK
        varchar password_hash
        varchar last_name
        varchar first_name
        varchar middle_name
        varchar phone
        varchar role "CLIENT | MECHANIC | MANAGER | DIRECTOR"
        boolean active
    }
    BRANDS {
        bigint id PK
        varchar name UK
    }
    MACHINE_MODELS {
        bigint id PK
        bigint brand_id FK
        varchar name
    }
    MACHINES {
        bigint id PK
        bigint model_id FK
        bigint owner_client_id FK
        varchar serial_number UK
        int manufacture_year
        date warranty_until
    }
    CONTRACTS {
        bigint id PK
        bigint client_id FK
        varchar number UK
        varchar type "SALE | SERVICE | PARTS_SUPPLY"
        date signed_date
        date end_date
        numeric amount
    }
    CONTRACT_MACHINES {
        bigint contract_id PK,FK
        bigint machine_id PK,FK
    }
    WORK_ORDERS {
        bigint id PK
        varchar number UK
        bigint client_id FK
        bigint machine_id FK
        bigint contract_id FK "NULL - без договора"
        varchar status "см. диаграмму статусов"
        text reason
        varchar place_of_work
        varchar contact_name
        varchar contact_phone
        date planned_date
        bigint created_by FK
        timestamptz created_at
    }
    WORK_ORDER_MECHANICS {
        bigint work_order_id PK,FK
        bigint mechanic_id PK,FK
    }
    WORK_ORDER_STATUS_HISTORY {
        bigint id PK
        bigint work_order_id FK
        varchar from_status
        varchar to_status
        bigint changed_by FK
        timestamptz changed_at
        text comment
    }
    JOBS {
        bigint id PK
        varchar name
        numeric norm_hours
        numeric price
    }
    WORK_ORDER_JOBS {
        bigint id PK
        bigint work_order_id FK
        bigint job_id FK
        numeric quantity
        numeric price "цена на момент наряда"
    }
    PARTS {
        bigint id PK
        varchar article UK
        varchar name
        numeric price
    }
    WORK_ORDER_PARTS {
        bigint id PK
        bigint work_order_id FK
        bigint part_id FK
        numeric quantity
        numeric price
        boolean client_supplied "запчасть клиента, цена 0"
    }
```

## Сущности

| Таблица | Назначение | Аналог в 1С |
|---|---|---|
| `clients` | Контрагент — юрлицо или физлицо, сторона договора | Справочник «Контрагенты» |
| `users` | Учётная запись: клиент, механик, менеджер, директор | Справочник «Пользователи» |
| `brands` | Производитель техники (МТЗ, John Deere) | Справочник «Производители» |
| `machine_models` | Модель техники (Беларус 82.1) | Справочник «Номенклатура» |
| `machines` | Конкретная машина с серийным номером | Серия номенклатуры |
| `contracts` | Договор продажи, сервиса или поставки запчастей | Справочник «Договоры контрагентов» |
| `contract_machines` | Какие машины входят в договор | Табличная часть договора |
| `work_orders` | Заказ-наряд на ремонт | Документ |
| `work_order_mechanics` | Механики, назначенные на заказ-наряд | Табличная часть документа |
| `work_order_status_history` | История смены статусов | Регистр сведений |
| `jobs` | Справочник работ с нормочасами и ценой | Справочник «Работы» |
| `work_order_jobs` | Работы в заказ-наряде | Табличная часть «Работы» |
| `parts` | Справочник запчастей | Справочник «Номенклатура» |
| `work_order_parts` | Запчасти в заказ-наряде | Табличная часть «Запчасти» |

## Перечисления

**`clients.type`**
- `LEGAL` (юридическое лицо)
- `INDIVIDUAL` (физическое лицо)

**`users.role`**
- `CLIENT` (клиент)
- `MECHANIC` (механик)
- `MANAGER` (менеджер)
- `DIRECTOR` (директор)

**`contracts.type`**
- `SALE` (купля-продажа)
- `SERVICE` (сервисное обслуживание)
- `PARTS_SUPPLY` (поставка запчастей)

## Статусы заказ-наряда

```mermaid
stateDiagram-v2
    state "NEW (Новая заявка)" as NEW
    state "ACCEPTED (Принята)" as ACCEPTED
    state "REJECTED (Отклонена)" as REJECTED
    state "CANCELLED (Отменена)" as CANCELLED
    state "ASSIGNED (Назначены механики)" as ASSIGNED
    state "IN_PROGRESS (В работе)" as IN_PROGRESS
    state "WAITING_PARTS (Ожидание запчастей)" as WAITING_PARTS
    state "DONE (Работы выполнены)" as DONE
    state "CLOSED (Закрыт)" as CLOSED

    [*] --> NEW : клиент создал заявку
    [*] --> ACCEPTED : менеджер создал по звонку
    NEW --> ACCEPTED : менеджер
    NEW --> REJECTED : менеджер
    NEW --> CANCELLED : клиент
    ACCEPTED --> ASSIGNED : менеджер назначил механиков
    ACCEPTED --> CANCELLED : клиент
    ASSIGNED --> CANCELLED : клиент
    ASSIGNED --> IN_PROGRESS : механик
    IN_PROGRESS --> WAITING_PARTS : механик
    WAITING_PARTS --> IN_PROGRESS : механик
    IN_PROGRESS --> DONE : механик
    DONE --> CLOSED : менеджер (акт, оплата)
    REJECTED --> [*]
    CANCELLED --> [*]
    CLOSED --> [*]
```

Каждый переход записывается в `work_order_status_history`.
Согласование сметы клиентом добавится отдельным статусом на этапе 3.

## Проектные решения

- **Клиент и пользователь разделены.** `clients` — сторона договора (юрлицо или физлицо), `users` — тот, кто входит в приложение. Сотрудники компании — пользователи без `client_id`.
- **Связи «один ко многим» — внешний ключ, без таблицы-связки.** Например, `contracts.client_id`. Отдельные таблицы только для «многие ко многим»: `contract_machines`, `work_order_mechanics`.
- **Владелец машины — клиент, а не пользователь** (`machines.owner_client_id`): все сотрудники клиента видят его технику.
- **Договор и машины — «многие ко многим».** В одном договоре может быть несколько машин, а одна машина может быть сначала в договоре продажи, потом в сервисном.
- **Заказ-наряд явно ссылается на договор-основание.** Через машину его не определить, ведь у машины может быть несколько договоров. `NULL` означает разовый ремонт без договора. Если договор указан, машина должна в нём быть (проверяется в коде).
- **`work_orders.client_id` — снимок на момент создания.** Владелец машины может смениться, а наряд остаётся за заказчиком.
- **Цена копируется в строку наряда.** Изменение цены в справочнике не меняет старые наряды.
- **Итоговая сумма наряда не хранится** — считается по табличным частям.
- **Деньги — `numeric`** (в Java `BigDecimal`), пароль хранится только в виде хеша.
- **Таблицы во множественном числе, сущности в единственном**: таблица `users` — класс `User`, `work_orders` — `WorkOrder`, связь через `@Table(name = "...")`. Заодно обходим `user` — зарезервированное слово в PostgreSQL. Исключение — `work_order_status_history`: «history» неисчисляемое.
