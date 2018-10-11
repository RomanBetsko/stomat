package com.ua.book.catalog.service.impl;

import com.ua.book.catalog.dao.BookDao;
import com.ua.book.catalog.service.MainService;
import com.ua.book.catalog.service.OrderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class MainServiceImpl implements MainService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private OrderCardService orderCardService;

    @Override
    @Transactional
    public ModelAndView getUnloginZoneData() {
        Map<String, Object> params = new HashMap<>();
        params.put("books", bookDao.findAll());
        return new ModelAndView("unloginzone", params);
    }

    @Override
    @Transactional
    public ModelAndView readerView() {
        Map<String, Object> params = new HashMap<>();
        params.put("books", bookDao.findAll());
        //todo refactor when will added multiusers
        params.put("orderCard", orderCardService.getCard(1));
        return new ModelAndView("reader", params);
    }
}
