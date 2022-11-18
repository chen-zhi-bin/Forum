package com.program.module_search.model.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;
import com.program.lib_common.Constants;

import java.io.Serializable;
import java.util.List;

public class SearchListBean implements Serializable {

    @SerializedName("success")
    private Boolean success; // FIXME check this code
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
        return "SearchListBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        @SerializedName("total")
        private Integer total; // FIXME check this code
        @SerializedName("pageSize")
        private Integer pageSize;
        @SerializedName("currentPage")
        private Integer currentPage;
        @SerializedName("hasNext")
        private Boolean hasNext;
        @SerializedName("hasPre")
        private Boolean hasPre;
        @SerializedName("totalPage")
        private Integer totalPage;
        @SerializedName("list")
        private List<ListBean> list;

        public Integer getTotal() {
            return total;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }

        public Boolean getHasNext() {
            return hasNext;
        }

        public Boolean getHasPre() {
            return hasPre;
        }

        public Integer getTotalPage() {
            return totalPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "total=" + total +
                    ", pageSize=" + pageSize +
                    ", currentPage=" + currentPage +
                    ", hasNext=" + hasNext +
                    ", hasPre=" + hasPre +
                    ", totalPage=" + totalPage +
                    ", list=" + list +
                    '}';
        }

        public static class ListBean implements Serializable , MultiItemEntity {
            /**
             * id : 1549301712764801026
             * title : 【Android】<font color='red'>tabLayout</font>改变标签<font color='red'>文字</font>大小时发生的跳闪问题解决方法
             * content : 如上图，<font color='red'>tabLayout</font>在选中时改变<font color='red'>文字</font>大小。贴下出问题的代码test.xml布局&lt;?xmlversion=&quot;1.0&quot;encoding=&quot;utf-8&quot;?
             * deleted : false
             * publishTime : 2022-07-19 15:57
             * labels : ["安卓","anroid"]
             * type : a
             * cover : https://images.sunofbeaches.com/content/2022_07_19/998981776019816448.png
             */

            @SerializedName("id")
            private String id;
            @SerializedName("title")
            private String title;
            @SerializedName("content")
            private String content;
            @SerializedName("deleted")
            private Boolean deleted;
            @SerializedName("publishTime")
            private String publishTime;
            @SerializedName("type")
            private String type;
            @SerializedName("cover")
            private String cover;
            @SerializedName("labels")
            private List<String> labels;

            public String getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public String getContent() {
                return content;
            }

            public Boolean getDeleted() {
                return deleted;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public String getType() {
                return type;
            }

            public String getCover() {
                return cover;
            }

            public List<String> getLabels() {
                return labels;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", content='" + content + '\'' +
                        ", deleted=" + deleted +
                        ", publishTime='" + publishTime + '\'' +
                        ", type='" + type + '\'' +
                        ", cover='" + cover + '\'' +
                        ", labels=" + labels +
                        '}';
            }

            @Override
            public int getItemType() {
                if (type.equals(Constants.Search.SEARCH_ARTICLE)){
                    return Constants.Search.SEARCH_INT_ARTICLE;
                }else if (type.equals(Constants.Search.SEARCH_WENDA)){
                    return Constants.Search.SEARCH_INT_WENDA;
                }else if (type.equals(Constants.Search.SEARCH_SHAPE)){
                    return Constants.Search.SEARCH_INT_SHAPE;
                }
                return 0;
            }
        }
    }
}
