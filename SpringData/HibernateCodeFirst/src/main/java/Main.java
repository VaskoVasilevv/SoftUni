import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("test")
                .createEntityManager();

//        entityManager.getTransaction().begin();
//
//        Sale sale = new Sale();
//        sale.setDateTime(LocalDateTime.now());
//
//        Product product = new Product();
//        product.setName("TestovProduct");
//        product.setPrice(BigDecimal.TEN);
//        product.setQuantity(5);
//
//        product.getSales().add(sale);
//        sale.setProduct(product);
//
//        entityManager.persist(product);
//
//
//        entityManager.getTransaction().commit();


    }
}
