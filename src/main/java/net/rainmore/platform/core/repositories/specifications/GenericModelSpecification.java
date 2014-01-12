package net.rainmore.platform.core.repositories.specifications;

import net.rainmore.platform.core.models.GenericModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GenericModelSpecification {
    public static Specification<GenericModel> activeSpecification(final Boolean active, final Boolean archived) {
        return new Specification<GenericModel>() {
            @Override
            public Predicate toPredicate(Root<GenericModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                predicate.getExpressions().add(cb.equal(root.<Boolean>get("active"), active));
                predicate.getExpressions().add(cb.equal(root.<Boolean>get("archived"), archived));
                return predicate;
            }
        };
    }

    public static Specification<GenericModel> archivedSpecification(final Boolean archived) {
        return new Specification<GenericModel>() {
            @Override
            public Predicate toPredicate(Root<GenericModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                predicate.getExpressions().add(cb.equal(root.<Boolean>get("archived"), archived));
                return predicate;
            }
        };
    }
}
