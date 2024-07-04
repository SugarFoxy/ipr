package perf.ipr.ui.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perf.ipr.ui.service.*;
import perf.ipr.ui.service.impl.*;
import perf.ipr.ui.storage.impl.SearchMovieStorage;

@Service
public class SearchMoviePage {
    public ButtonService buttonService;
    public ElemCardService elemCardService;
    public InputService inputService;
    public SelectService selectService;
    public CheckBoxService checkBoxService;

    @Autowired
    public SearchMoviePage(SearchMovieStorage storage) {
        buttonService = new ButtonServiceImpl(storage);
        elemCardService = new ElemCardServiceImpl(storage);
        inputService = new InputServiceImpl(storage);
        selectService = new SelectServiceImpl(storage);
        checkBoxService = new CheckBoxServiceImpl(storage);
    }
}
