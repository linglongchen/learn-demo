package com.example.demo.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 2022/4/20 19:45
 */
public class ApplicationHandler implements BaseHandler {


    private List<BaseFilter> baseFilters;

    public ApplicationHandler(List<BaseFilter> baseFilters) {
        this.baseFilters = baseFilters;
    }


    @Override
    public Object handle(Object obj) {
        List<BaseFilter> list = new ArrayList<>(baseFilters);
        return new DefaultFilterChain(list).doFilter(obj) ;
    }

    private static class DefaultFilterChain implements BaseFilterChain {
        private final int index;

        private final List<BaseFilter> filters;

        private DefaultFilterChain(DefaultFilterChain parentChain,int nextIndex) {
            this.filters = parentChain.filters;
            this.index = nextIndex;
        }

        private DefaultFilterChain(List<BaseFilter> filters) {
            this.filters = filters;
            this.index = 0;
        }

        public int getIndex() {
            return index;
        }

        public List<BaseFilter> getFilters() {
            return filters;
        }

        @Override
        public Object doFilter(Object obj) {
            if (this.index < filters.size()) {
                BaseFilter filter = filters.get(this.index);
                DefaultFilterChain chain = new DefaultFilterChain(this,this.index + 1);
                return filter.doFilter(obj,chain);
            }
            return null;
        }

    }
}
