package markup;
 
public class Text{
    private String s;
    public Text (String s){
        this.s = s;
    }
    public void toMarkdown(StringBuilder str){
        str.append(s);  
    }

    public void toHTML(StringBuilder str) {
        str.append(s);
    }
}