package iuh.fit.se.daos.impl;

import iuh.fit.se.daos.DanhMucDao;
import iuh.fit.se.models.DanhMuc;
import jakarta.persistence.EntityManager;

public class DanhMucDaoImpl extends GenericDaoImpl<DanhMuc> implements DanhMucDao {
    public DanhMucDaoImpl(EntityManager em, Class<DanhMuc> clazz) {
        super(em, clazz);
    }

    public DanhMucDaoImpl() {
        super(DanhMuc.class);
    }
}
