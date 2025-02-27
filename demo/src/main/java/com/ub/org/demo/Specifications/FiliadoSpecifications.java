package com.ub.org.demo.Specifications;
 // Ajuste para o pacote correto
import com.ub.org.demo.view.Filiados;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
public class FiliadoSpecifications {
   

public static Specification<Filiados> hasNome(String nome) {
    return (Root<Filiados> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
        if (query.getResultType() != Long.class) { // Garante que não aplicamos ordenação em queries de contagem
            query.orderBy(criteriaBuilder.asc(root.get("nome"))); // Ordenação crescente
        }

        if (nome == null || nome.isEmpty()) {
            return criteriaBuilder.conjunction();
        }
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    };
}

    public static Specification<Filiados> hasCpf(String cpf) {
        return (root, query, criteriaBuilder) -> {
            if (cpf == null || cpf.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("cpf"), cpf);
        };
    }

    public static Specification<Filiados> hasTitulo(String titulo) {
        return (root, query, criteriaBuilder) -> {
            if (titulo == null || titulo.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("titulo"), titulo);
        };
    }

    public static Specification<Filiados> hasUf(String uf) {
        return (root, query, criteriaBuilder) -> {
            if (uf == null || uf.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("uf"), uf);
        };
    }

    public static Specification<Filiados> hasMunicipio(String municipio) {
        return (root, query, criteriaBuilder) -> {
            if (municipio == null || municipio.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("municipio"), municipio);
        };
    }

    public static Specification<Filiados> hasDataFiliacao(String dataFiliacao) {
        return (root, query, criteriaBuilder) -> {
            if (dataFiliacao == null || dataFiliacao.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("dataFiliacao"), dataFiliacao);
        };
    }
}
