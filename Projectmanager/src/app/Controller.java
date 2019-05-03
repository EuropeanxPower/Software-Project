package app;

class Controller {

    private UI ui;
    private Model model;

    //Constructor
    Controller(Model model, UI ui){
        this.model = model;
        this.ui = ui;
    }

}