package com.example.sbootdemo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReservationOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNull() {
            addCriterion("user_address is null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNotNull() {
            addCriterion("user_address is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddressEqualTo(String value) {
            addCriterion("user_address =", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotEqualTo(String value) {
            addCriterion("user_address <>", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThan(String value) {
            addCriterion("user_address >", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("user_address >=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThan(String value) {
            addCriterion("user_address <", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThanOrEqualTo(String value) {
            addCriterion("user_address <=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLike(String value) {
            addCriterion("user_address like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotLike(String value) {
            addCriterion("user_address not like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressIn(List<String> values) {
            addCriterion("user_address in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotIn(List<String> values) {
            addCriterion("user_address not in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressBetween(String value1, String value2) {
            addCriterion("user_address between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotBetween(String value1, String value2) {
            addCriterion("user_address not between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIsNull() {
            addCriterion("sale_store is null");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIsNotNull() {
            addCriterion("sale_store is not null");
            return (Criteria) this;
        }

        public Criteria andSaleStoreEqualTo(String value) {
            addCriterion("sale_store =", value, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreNotEqualTo(String value) {
            addCriterion("sale_store <>", value, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreGreaterThan(String value) {
            addCriterion("sale_store >", value, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreGreaterThanOrEqualTo(String value) {
            addCriterion("sale_store >=", value, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreLessThan(String value) {
            addCriterion("sale_store <", value, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreLessThanOrEqualTo(String value) {
            addCriterion("sale_store <=", value, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreLike(String value) {
            addCriterion("sale_store like", value, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreNotLike(String value) {
            addCriterion("sale_store not like", value, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreIn(List<String> values) {
            addCriterion("sale_store in", values, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreNotIn(List<String> values) {
            addCriterion("sale_store not in", values, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreBetween(String value1, String value2) {
            addCriterion("sale_store between", value1, value2, "saleStore");
            return (Criteria) this;
        }

        public Criteria andSaleStoreNotBetween(String value1, String value2) {
            addCriterion("sale_store not between", value1, value2, "saleStore");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicIsNull() {
            addCriterion("door_panoramic is null");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicIsNotNull() {
            addCriterion("door_panoramic is not null");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicEqualTo(String value) {
            addCriterion("door_panoramic =", value, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicNotEqualTo(String value) {
            addCriterion("door_panoramic <>", value, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicGreaterThan(String value) {
            addCriterion("door_panoramic >", value, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicGreaterThanOrEqualTo(String value) {
            addCriterion("door_panoramic >=", value, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicLessThan(String value) {
            addCriterion("door_panoramic <", value, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicLessThanOrEqualTo(String value) {
            addCriterion("door_panoramic <=", value, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicLike(String value) {
            addCriterion("door_panoramic like", value, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicNotLike(String value) {
            addCriterion("door_panoramic not like", value, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicIn(List<String> values) {
            addCriterion("door_panoramic in", values, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicNotIn(List<String> values) {
            addCriterion("door_panoramic not in", values, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicBetween(String value1, String value2) {
            addCriterion("door_panoramic between", value1, value2, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorPanoramicNotBetween(String value1, String value2) {
            addCriterion("door_panoramic not between", value1, value2, "doorPanoramic");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessIsNull() {
            addCriterion("door_thickness is null");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessIsNotNull() {
            addCriterion("door_thickness is not null");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessEqualTo(String value) {
            addCriterion("door_thickness =", value, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessNotEqualTo(String value) {
            addCriterion("door_thickness <>", value, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessGreaterThan(String value) {
            addCriterion("door_thickness >", value, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessGreaterThanOrEqualTo(String value) {
            addCriterion("door_thickness >=", value, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessLessThan(String value) {
            addCriterion("door_thickness <", value, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessLessThanOrEqualTo(String value) {
            addCriterion("door_thickness <=", value, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessLike(String value) {
            addCriterion("door_thickness like", value, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessNotLike(String value) {
            addCriterion("door_thickness not like", value, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessIn(List<String> values) {
            addCriterion("door_thickness in", values, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessNotIn(List<String> values) {
            addCriterion("door_thickness not in", values, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessBetween(String value1, String value2) {
            addCriterion("door_thickness between", value1, value2, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andDoorThicknessNotBetween(String value1, String value2) {
            addCriterion("door_thickness not between", value1, value2, "doorThickness");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthIsNull() {
            addCriterion("edge_length is null");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthIsNotNull() {
            addCriterion("edge_length is not null");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthEqualTo(String value) {
            addCriterion("edge_length =", value, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthNotEqualTo(String value) {
            addCriterion("edge_length <>", value, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthGreaterThan(String value) {
            addCriterion("edge_length >", value, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthGreaterThanOrEqualTo(String value) {
            addCriterion("edge_length >=", value, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthLessThan(String value) {
            addCriterion("edge_length <", value, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthLessThanOrEqualTo(String value) {
            addCriterion("edge_length <=", value, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthLike(String value) {
            addCriterion("edge_length like", value, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthNotLike(String value) {
            addCriterion("edge_length not like", value, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthIn(List<String> values) {
            addCriterion("edge_length in", values, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthNotIn(List<String> values) {
            addCriterion("edge_length not in", values, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthBetween(String value1, String value2) {
            addCriterion("edge_length between", value1, value2, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andEdgeLengthNotBetween(String value1, String value2) {
            addCriterion("edge_length not between", value1, value2, "edgeLength");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andVisitDateIsNull() {
            addCriterion("visit_date is null");
            return (Criteria) this;
        }

        public Criteria andVisitDateIsNotNull() {
            addCriterion("visit_date is not null");
            return (Criteria) this;
        }

        public Criteria andVisitDateEqualTo(Date value) {
            addCriterion("visit_date =", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateNotEqualTo(Date value) {
            addCriterion("visit_date <>", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateGreaterThan(Date value) {
            addCriterion("visit_date >", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("visit_date >=", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateLessThan(Date value) {
            addCriterion("visit_date <", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateLessThanOrEqualTo(Date value) {
            addCriterion("visit_date <=", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateIn(List<Date> values) {
            addCriterion("visit_date in", values, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateNotIn(List<Date> values) {
            addCriterion("visit_date not in", values, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateBetween(Date value1, Date value2) {
            addCriterion("visit_date between", value1, value2, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateNotBetween(Date value1, Date value2) {
            addCriterion("visit_date not between", value1, value2, "visitDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}