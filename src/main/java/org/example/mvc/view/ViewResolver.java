package org.example.mvc.view;

/**
 * View 이름으로 View를 결정
 */
public interface ViewResolver {

    View resolveView(String viewName);
}
