package markup;
import java.util.List;
 
public class Paragraph extends MyAbstractClass {
    public void toMarkdown(StringBuilder str){
        in(str, "");
    }

    public void toHTML(StringBuilder str) {
        in2(str, "", "");
    }

    public Paragraph(List list) {
        this.list = list;
    }
}