package iuh.fit.se.daos.impl;

import iuh.fit.se.daos.TinTucDao;
import iuh.fit.se.models.TinTuc;
import jakarta.persistence.EntityManager;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TinTucDaoImpl extends GenericDaoImpl<TinTuc> implements TinTucDao {
    public TinTucDaoImpl(EntityManager em, Class<TinTuc> clazz) {
        super(em, clazz);
    }

    public TinTucDaoImpl() {
        super(TinTuc.class);
    }

    @Override
    public Set<TinTuc> findByDanhMucInOrder(String maDanhMuc, boolean desc) {
        String sql = "from TinTuc t where t.danhMuc.maDM = :maDanhMuc order by t.maTT " + (desc? "desc" : "asc");
        return em.createQuery(sql, TinTuc.class)
                .setParameter("maDanhMuc", maDanhMuc)
                .getResultStream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Set<TinTuc> getAllInOrder(boolean desc) {
        String sql = "from TinTuc t order by t.maTT " + (desc? "desc" : "asc");
        return em.createQuery(sql, TinTuc.class)
                .getResultStream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
