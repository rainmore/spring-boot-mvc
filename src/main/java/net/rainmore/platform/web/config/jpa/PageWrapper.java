package net.rainmore.platform.web.config.jpa;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageWrapper<T> {
    public static final int MAX_PAGE_ITEM_DISPLAY = 5;
    public static final int START_NUMBER = 0;
    private Page<T> page;
    private List<PageItem> items;
    private int currentNumber;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PageWrapper(Page<T> page, String url){
        this.page = page;
        this.url = url;
        items = new ArrayList<PageItem>();

        currentNumber = page.getNumber();

        int start, size;
        if (page.getTotalPages() <= MAX_PAGE_ITEM_DISPLAY){
            start = START_NUMBER;
            size = page.getTotalPages();
        } else {
            if (currentNumber <= MAX_PAGE_ITEM_DISPLAY - MAX_PAGE_ITEM_DISPLAY/2){
                start = START_NUMBER;
                size = MAX_PAGE_ITEM_DISPLAY;
            } else if (currentNumber >= page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY/2){
                start = page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY;
                size = MAX_PAGE_ITEM_DISPLAY;
            } else {
                start = currentNumber - MAX_PAGE_ITEM_DISPLAY/2;
                size = MAX_PAGE_ITEM_DISPLAY;
            }
        }

        for (int i = 0; i<size; i++){
            items.add(new PageItem(start + i, (start + i) == currentNumber));
        }
    }

    public List<PageItem> getItems(){
        return items;
    }

    public int getNumber(){
        return currentNumber;
    }

    public List<T> getContent(){
        return page.getContent();
    }

    public int getSize(){
        return page.getSize();
    }

    public int getTotalPages(){
        return page.getTotalPages();
    }

    public boolean isFirstPage(){
        return page.isFirstPage();
    }

    public boolean isLastPage(){
        return page.isLastPage();
    }

    public boolean isHasPreviousPage(){
        return page.hasPreviousPage();
    }

    public boolean isHasNextPage(){
        return page.hasNextPage();
    }

    public class PageItem {
        private int number;
        private boolean current;
        public PageItem(int number, boolean current){
            this.number = number;
            this.current = current;
        }

        public int getNumber(){
            return this.number;
        }

        public boolean isCurrent(){
            return this.current;
        }
    }
}