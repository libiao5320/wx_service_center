package com.royao.model.base;

/**
 * Created by libia on 2016/1/3.
 */
public class PageObject {
	
    private final static Integer DEFAULT_PAGE_SIZE = 10;//每页大小
    protected Integer pageNo = 1;	//第几页
    protected Integer pageSize = DEFAULT_PAGE_SIZE;
    protected Long total = 0L;	//所有条数


    private Integer begin = 0;
    private Integer end = 0;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {


        this.pageNo = pageNo;

        begin = (this.pageNo - 1) * this.pageSize;
        end = this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;

        begin = (this.pageNo - 1) * this.pageSize;
        end =  this.pageSize;
    }

    /**
     * 获取总的记录数
     *
     * @return
     */
    public Long getTotal() {
        return total;
    }


    public void setTotal(final Long totalCount) {
        this.total = totalCount;
    }


    /**
     * 获取总的页数
     *
     * @return
     */
    public Long getTotalPages() {
    	Long count = total / pageSize;
        if (total % pageSize > 0) {
            count++;
        }
        return count;
    }


    public boolean isHasNext() {
        return (pageNo + 1 <= getTotalPages());
    }

    /**
     * 获取下一页页码
     *
     * @return
     */
    public Integer getNextPage() {
        if (isHasNext()) {
            return pageNo + 1;
        } else {
            return pageNo;
        }
    }


    public boolean isHasPre() {
        return (pageNo - 1 >= 1);
    }


    public Integer getPrePage() {
        if (isHasPre()) {
            return pageNo - 1;
        } else {
            return pageNo;
        }
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
