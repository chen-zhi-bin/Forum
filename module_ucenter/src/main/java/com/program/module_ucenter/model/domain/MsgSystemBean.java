package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class MsgSystemBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 查询成功.
     * data : {"content":[{"_id":"1020635872225132544","title":"每日登录奖励","publishTime":"2022-09-17 10:02","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1020274249438330880","title":"每日登录奖励","publishTime":"2022-09-16 10:05","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1020051502791655424","title":"每日登录奖励","publishTime":"2022-09-15 19:20","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1019558873960284160","title":"每日登录奖励","publishTime":"2022-09-14 10:42","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1018928924370927616","title":"每日登录奖励","publishTime":"2022-09-12 16:59","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1018463444824752128","title":"每日登录奖励","publishTime":"2022-09-11 10:10","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1018263152803971072","title":"每日登录奖励","publishTime":"2022-09-10 20:54","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1017758699222990848","title":"每日登录奖励","publishTime":"2022-09-09 11:29","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1017465643982651392","title":"每日登录奖励","publishTime":"2022-09-08 16:05","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1017168973965295616","title":"每日登录奖励","publishTime":"2022-09-07 20:26","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1015634360507826176","title":"每日登录奖励","publishTime":"2022-09-03 14:48","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1015227645501112320","title":"每日登录奖励","publishTime":"2022-09-02 11:52","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1014864482360360960","title":"每日登录奖励","publishTime":"2022-09-01 11:49","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1014541495471964160","title":"每日登录奖励","publishTime":"2022-08-31 14:25","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1013095309657505792","title":"每日登录奖励","publishTime":"2022-08-27 14:39","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1012781886788861952","title":"每日登录奖励","publishTime":"2022-08-26 17:53","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1012313882569474048","title":"每日登录奖励","publishTime":"2022-08-25 10:53","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1011602433442316288","title":"每日登录奖励","publishTime":"2022-08-23 11:46","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1006319906381103104","title":"每日登录奖励","publishTime":"2022-08-08 21:56","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1005802775403036672","title":"每日登录奖励","publishTime":"2022-08-07 11:41","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1005500657408409600","title":"每日登录奖励","publishTime":"2022-08-06 15:40","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1005239393146896384","title":"每日登录奖励","publishTime":"2022-08-05 22:22","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1004711815441022976","title":"每日登录奖励","publishTime":"2022-08-04 11:26","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1004158763625611264","title":"每日登录奖励","publishTime":"2022-08-02 22:48","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1003608889402327040","title":"每日登录奖励","publishTime":"2022-08-01 10:23","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1003268803317989376","title":"每日登录奖励","publishTime":"2022-07-31 11:52","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1002898972102098944","title":"每日登录奖励","publishTime":"2022-07-30 11:22","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1002600150067052544","title":"每日登录奖励","publishTime":"2022-07-29 15:35","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1002163338743906304","title":"每日登录奖励","publishTime":"2022-07-28 10:39","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1001977431956914176","title":"每日登录奖励","publishTime":"2022-07-27 22:20","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"}],"pageable":{"sort":{"sorted":true,"unsorted":false},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"totalPages":4,"totalElements":101,"last":false,"number":0,"size":30,"numberOfElements":30,"sort":{"sorted":true,"unsorted":false},"first":true}
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataBean data;

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataBean getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MsgSystemBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * content : [{"_id":"1020635872225132544","title":"每日登录奖励","publishTime":"2022-09-17 10:02","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1020274249438330880","title":"每日登录奖励","publishTime":"2022-09-16 10:05","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1020051502791655424","title":"每日登录奖励","publishTime":"2022-09-15 19:20","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1019558873960284160","title":"每日登录奖励","publishTime":"2022-09-14 10:42","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1018928924370927616","title":"每日登录奖励","publishTime":"2022-09-12 16:59","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1018463444824752128","title":"每日登录奖励","publishTime":"2022-09-11 10:10","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1018263152803971072","title":"每日登录奖励","publishTime":"2022-09-10 20:54","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1017758699222990848","title":"每日登录奖励","publishTime":"2022-09-09 11:29","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1017465643982651392","title":"每日登录奖励","publishTime":"2022-09-08 16:05","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1017168973965295616","title":"每日登录奖励","publishTime":"2022-09-07 20:26","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1015634360507826176","title":"每日登录奖励","publishTime":"2022-09-03 14:48","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1015227645501112320","title":"每日登录奖励","publishTime":"2022-09-02 11:52","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1014864482360360960","title":"每日登录奖励","publishTime":"2022-09-01 11:49","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1014541495471964160","title":"每日登录奖励","publishTime":"2022-08-31 14:25","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1013095309657505792","title":"每日登录奖励","publishTime":"2022-08-27 14:39","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1012781886788861952","title":"每日登录奖励","publishTime":"2022-08-26 17:53","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1012313882569474048","title":"每日登录奖励","publishTime":"2022-08-25 10:53","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1011602433442316288","title":"每日登录奖励","publishTime":"2022-08-23 11:46","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1006319906381103104","title":"每日登录奖励","publishTime":"2022-08-08 21:56","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1005802775403036672","title":"每日登录奖励","publishTime":"2022-08-07 11:41","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1005500657408409600","title":"每日登录奖励","publishTime":"2022-08-06 15:40","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1005239393146896384","title":"每日登录奖励","publishTime":"2022-08-05 22:22","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1004711815441022976","title":"每日登录奖励","publishTime":"2022-08-04 11:26","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1004158763625611264","title":"每日登录奖励","publishTime":"2022-08-02 22:48","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1003608889402327040","title":"每日登录奖励","publishTime":"2022-08-01 10:23","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1003268803317989376","title":"每日登录奖励","publishTime":"2022-07-31 11:52","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1002898972102098944","title":"每日登录奖励","publishTime":"2022-07-30 11:22","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1002600150067052544","title":"每日登录奖励","publishTime":"2022-07-29 15:35","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1002163338743906304","title":"每日登录奖励","publishTime":"2022-07-28 10:39","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"},{"_id":"1001977431956914176","title":"每日登录奖励","publishTime":"2022-07-27 22:20","content":"<a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币<\/a> 感谢有你！","state":"1","exId":null,"exType":"sobTrade","userId":"1499922423573647361"}]
         * pageable : {"sort":{"sorted":true,"unsorted":false},"pageSize":30,"pageNumber":0,"offset":0,"paged":true,"unpaged":false}
         * totalPages : 4
         * totalElements : 101
         * last : false
         * number : 0
         * size : 30
         * numberOfElements : 30
         * sort : {"sorted":true,"unsorted":false}
         * first : true
         */

        @SerializedName("pageable")
        private PageableBean pageable;
        @SerializedName("totalPages")
        private Integer totalPages;
        @SerializedName("totalElements")
        private Integer totalElements;
        @SerializedName("last")
        private Boolean last;
        @SerializedName("number")
        private Integer number;
        @SerializedName("size")
        private Integer size;
        @SerializedName("numberOfElements")
        private Integer numberOfElements;
        @SerializedName("sort")
        private SortBeanX sort;
        @SerializedName("first")
        private Boolean first;
        @SerializedName("content")
        private List<ContentBean> content;

        public PageableBean getPageable() {
            return pageable;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public Integer getTotalElements() {
            return totalElements;
        }

        public Boolean getLast() {
            return last;
        }

        public Integer getNumber() {
            return number;
        }

        public Integer getSize() {
            return size;
        }

        public Integer getNumberOfElements() {
            return numberOfElements;
        }

        public SortBeanX getSort() {
            return sort;
        }

        public Boolean getFirst() {
            return first;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "pageable=" + pageable +
                    ", totalPages=" + totalPages +
                    ", totalElements=" + totalElements +
                    ", last=" + last +
                    ", number=" + number +
                    ", size=" + size +
                    ", numberOfElements=" + numberOfElements +
                    ", sort=" + sort +
                    ", first=" + first +
                    ", content=" + content +
                    '}';
        }

        public static class PageableBean implements Serializable {
            /**
             * sort : {"sorted":true,"unsorted":false}
             * pageSize : 30
             * pageNumber : 0
             * offset : 0
             * paged : true
             * unpaged : false
             */

            @SerializedName("sort")
            private SortBean sort;
            @SerializedName("pageSize")
            private Integer pageSize;
            @SerializedName("pageNumber")
            private Integer pageNumber;
            @SerializedName("offset")
            private Integer offset;
            @SerializedName("paged")
            private Boolean paged;
            @SerializedName("unpaged")
            private Boolean unpaged;

            public SortBean getSort() {
                return sort;
            }

            public Integer getPageSize() {
                return pageSize;
            }

            public Integer getPageNumber() {
                return pageNumber;
            }

            public Integer getOffset() {
                return offset;
            }

            public Boolean getPaged() {
                return paged;
            }

            public Boolean getUnpaged() {
                return unpaged;
            }

            @Override
            public String toString() {
                return "PageableBean{" +
                        "sort=" + sort +
                        ", pageSize=" + pageSize +
                        ", pageNumber=" + pageNumber +
                        ", offset=" + offset +
                        ", paged=" + paged +
                        ", unpaged=" + unpaged +
                        '}';
            }

            public static class SortBean implements Serializable {
                /**
                 * sorted : true
                 * unsorted : false
                 */

                @SerializedName("sorted")
                private Boolean sorted;
                @SerializedName("unsorted")
                private Boolean unsorted;


                public Boolean getSorted() {
                    return sorted;
                }

                public Boolean getUnsorted() {
                    return unsorted;
                }

                @Override
                public String toString() {
                    return "SortBean{" +
                            "sorted=" + sorted +
                            ", unsorted=" + unsorted +
                            '}';
                }
            }
        }

        public static class SortBeanX implements Serializable {
            /**
             * sorted : true
             * unsorted : false
             */

            @SerializedName("sorted")
            private Boolean sorted;
            @SerializedName("unsorted")
            private Boolean unsorted;

            public Boolean getSorted() {
                return sorted;
            }

            public Boolean getUnsorted() {
                return unsorted;
            }

            @Override
            public String toString() {
                return "SortBeanX{" +
                        "sorted=" + sorted +
                        ", unsorted=" + unsorted +
                        '}';
            }
        }

        public static class ContentBean implements Serializable {
            /**
             * _id : 1020635872225132544
             * title : 每日登录奖励
             * publishTime : 2022-09-17 10:02
             * content : <a href='https://mp.sunofbeach.net/#/index/setting/sobRecord' style='color:#e6a23c'>每日登录奖励2个sunof币</a> 感谢有你！
             * state : 1
             * exId : null
             * exType : sobTrade
             * userId : 1499922423573647361
             */

            @SerializedName("_id")
            private String id;
            @SerializedName("title")
            private String title;
            @SerializedName("publishTime")
            private String publishTime;
            @SerializedName("content")
            private String content;
            @SerializedName("state")
            private String state;
            @SerializedName("exId")
            private Object exId;
            @SerializedName("exType")
            private String exType;
            @SerializedName("userId")
            private String userId;

            public String getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public String getContent() {
                return content;
            }

            public String getState() {
                return state;
            }

            public Object getExId() {
                return exId;
            }

            public String getExType() {
                return exType;
            }

            public String getUserId() {
                return userId;
            }

            @Override
            public String toString() {
                return "ContentBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", publishTime='" + publishTime + '\'' +
                        ", content='" + content + '\'' +
                        ", state='" + state + '\'' +
                        ", exId=" + exId +
                        ", exType='" + exType + '\'' +
                        ", userId='" + userId + '\'' +
                        '}';
            }
        }
    }
}
