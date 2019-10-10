package com.it.www.util;

import java.io.Serializable;
import java.util.Date;

public class QueryTool implements Serializable {

    //private static final long serialVersionUID = 42L;

    private String queryName;//查询姓名
    private Integer queryDeptId; //查询部门
    private Date minBirthday; //最小生日时间
    private Date maxBirthday; //最大生日时间
    private Integer currentPage; //当前页码
    private Integer pageSize; //分页单位

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public Integer getQueryDeptId() {
        return queryDeptId;
    }

    public void setQueryDeptId(Integer queryDeptId) {
        this.queryDeptId = queryDeptId;
    }

    public Date getMinBirthday() {
        return minBirthday;
    }

    public void setMinBirthday(Date minBirthday) {
        this.minBirthday = minBirthday;
    }

    public Date getMaxBirthday() {
        return maxBirthday;
    }

    public void setMaxBirthday(Date maxBirthday) {
        this.maxBirthday = maxBirthday;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public QueryTool() {
    }

    public QueryTool(String queryName, Integer queryDeptId, Date minBirthday, Date maxBirthday, Integer currentPage) {
        this.queryName = queryName;
        this.queryDeptId = queryDeptId;
        this.minBirthday = minBirthday;
        this.maxBirthday = maxBirthday;
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "QueryTool{" +
                "queryName='" + queryName + '\'' +
                ", queryDeptId=" + queryDeptId +
                ", minBirthday=" + minBirthday +
                ", maxBirthday=" + maxBirthday +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
