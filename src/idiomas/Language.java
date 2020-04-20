package idiomas;

import javax.swing.JComboBox;
class Language extends JComboBox{
    
    public Language(){
        for(lang a:lang.values()){
            this.addItem(a);
        }
    }
    
}