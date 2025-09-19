package iuh.fit.se.daos;

import iuh.fit.se.models.TinTuc;

import java.util.Set;

public interface TinTucDao extends GenericDao<TinTuc> {
    public Set<TinTuc> findByDanhMucInOrder(String maDanhMuc, boolean desc);

    public Set<TinTuc> getAllInOrder(boolean desc);
}
