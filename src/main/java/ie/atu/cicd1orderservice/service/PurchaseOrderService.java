package ie.atu.cicd1orderservice.service;


import ie.atu.cicd1orderservice.client.CatalogClient;
import ie.atu.cicd1orderservice.client.dto.ProductResponse;
import ie.atu.cicd1orderservice.model.PurchaseOrder;
import ie.atu.cicd1orderservice.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository repository;
    private final CatalogClient catalogClient;


    public PurchaseOrderService(PurchaseOrderRepository repository, CatalogClient catalogClient) {
        this.repository = repository;
        this.catalogClient = catalogClient;
    }


    public ProductResponse testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }
    public List<PurchaseOrder> getAll() {
        return repository.findAll();
    }

    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(null);
        return repository.save(order);
    }
}
