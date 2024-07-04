package perf.ipr.ui.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perf.ipr.ui.service.ElementService;
import perf.ipr.ui.service.impl.ElementServiceImpl;
import perf.ipr.ui.storage.impl.MoviePageStorage;

@Service
public class MoviePage {
    public ElementService elementsService;

    @Autowired
    public MoviePage(MoviePageStorage storage) {
        elementsService = new ElementServiceImpl(storage);
    }
}
