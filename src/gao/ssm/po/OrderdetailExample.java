package gao.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class OrderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderdetailExample() {
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

        public Criteria andOrdersidIsNull() {
            addCriterion("ordersId is null");
            return (Criteria) this;
        }

        public Criteria andOrdersidIsNotNull() {
            addCriterion("ordersId is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersidEqualTo(Integer value) {
            addCriterion("ordersId =", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidNotEqualTo(Integer value) {
            addCriterion("ordersId <>", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidGreaterThan(Integer value) {
            addCriterion("ordersId >", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ordersId >=", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidLessThan(Integer value) {
            addCriterion("ordersId <", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidLessThanOrEqualTo(Integer value) {
            addCriterion("ordersId <=", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidIn(List<Integer> values) {
            addCriterion("ordersId in", values, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidNotIn(List<Integer> values) {
            addCriterion("ordersId not in", values, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidBetween(Integer value1, Integer value2) {
            addCriterion("ordersId between", value1, value2, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidNotBetween(Integer value1, Integer value2) {
            addCriterion("ordersId not between", value1, value2, "ordersid");
            return (Criteria) this;
        }

        public Criteria andItemsidIsNull() {
            addCriterion("itemsId is null");
            return (Criteria) this;
        }

        public Criteria andItemsidIsNotNull() {
            addCriterion("itemsId is not null");
            return (Criteria) this;
        }

        public Criteria andItemsidEqualTo(Integer value) {
            addCriterion("itemsId =", value, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsidNotEqualTo(Integer value) {
            addCriterion("itemsId <>", value, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsidGreaterThan(Integer value) {
            addCriterion("itemsId >", value, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("itemsId >=", value, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsidLessThan(Integer value) {
            addCriterion("itemsId <", value, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsidLessThanOrEqualTo(Integer value) {
            addCriterion("itemsId <=", value, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsidIn(List<Integer> values) {
            addCriterion("itemsId in", values, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsidNotIn(List<Integer> values) {
            addCriterion("itemsId not in", values, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsidBetween(Integer value1, Integer value2) {
            addCriterion("itemsId between", value1, value2, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsidNotBetween(Integer value1, Integer value2) {
            addCriterion("itemsId not between", value1, value2, "itemsid");
            return (Criteria) this;
        }

        public Criteria andItemsnumIsNull() {
            addCriterion("itemsNum is null");
            return (Criteria) this;
        }

        public Criteria andItemsnumIsNotNull() {
            addCriterion("itemsNum is not null");
            return (Criteria) this;
        }

        public Criteria andItemsnumEqualTo(Integer value) {
            addCriterion("itemsNum =", value, "itemsnum");
            return (Criteria) this;
        }

        public Criteria andItemsnumNotEqualTo(Integer value) {
            addCriterion("itemsNum <>", value, "itemsnum");
            return (Criteria) this;
        }

        public Criteria andItemsnumGreaterThan(Integer value) {
            addCriterion("itemsNum >", value, "itemsnum");
            return (Criteria) this;
        }

        public Criteria andItemsnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("itemsNum >=", value, "itemsnum");
            return (Criteria) this;
        }

        public Criteria andItemsnumLessThan(Integer value) {
            addCriterion("itemsNum <", value, "itemsnum");
            return (Criteria) this;
        }

        public Criteria andItemsnumLessThanOrEqualTo(Integer value) {
            addCriterion("itemsNum <=", value, "itemsnum");
            return (Criteria) this;
        }

        public Criteria andItemsnumIn(List<Integer> values) {
            addCriterion("itemsNum in", values, "itemsnum");
            return (Criteria) this;
        }

        public Criteria andItemsnumNotIn(List<Integer> values) {
            addCriterion("itemsNum not in", values, "itemsnum");
            return (Criteria) this;
        }

        public Criteria andItemsnumBetween(Integer value1, Integer value2) {
            addCriterion("itemsNum between", value1, value2, "itemsnum");
            return (Criteria) this;
        }

        public Criteria andItemsnumNotBetween(Integer value1, Integer value2) {
            addCriterion("itemsNum not between", value1, value2, "itemsnum");
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