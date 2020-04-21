package idiomas;

import javax.swing.JComboBox;
class Language extends JComboBox{
    lang DefaulIdioma=lang.es;
    public Language(){
        msg.setIdioma(DefaulIdioma);
        for(lang a:lang.values()){
            this.addItem(a);
        }
    }
    
}