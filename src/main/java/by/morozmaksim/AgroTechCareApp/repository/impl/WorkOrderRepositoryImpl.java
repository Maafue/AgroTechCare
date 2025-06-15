package by.morozmaksim.AgroTechCareApp.repository.impl;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCareApp.repository.WorkOrderRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WorkOrderRepositoryImpl implements WorkOrderRepository {

    private final SessionFactory sessionFactory;

    @Override
    public WorkOrder create(WorkOrder workOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(workOrder);
        session.getTransaction().commit();

        return workOrder;
    }

    @Override
    public WorkOrder update(WorkOrder workOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(workOrder);
        session.getTransaction().commit();
        return workOrder;
    }

    @Override
    public WorkOrder findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        WorkOrder workOrder = session.get(WorkOrder.class, id);
        session.getTransaction().commit();
        return workOrder;
    }

    @Override
    public List<WorkOrder> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<WorkOrder> workOrders = session.createQuery("from WorkOrder", WorkOrder.class).getResultList();
        session.getTransaction().commit();
        return workOrders;
    }

    @Override
    public void delete(WorkOrder workOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(workOrder);
        session.getTransaction().commit();
    }
}
