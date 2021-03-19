package markup;
import java.util.List;
 
public class Strikeout extends MyAbstractClass {
    public void toMarkdown(StringBuilder str){
        in(str, "~");
    }

    @Override
    public void toHTML(StringBuilder str) {
        in2(str, "<s>", "</s>");
    }

    public Strikeout(List<CanMarkdown> list){
        this.list = list;
    }
}
