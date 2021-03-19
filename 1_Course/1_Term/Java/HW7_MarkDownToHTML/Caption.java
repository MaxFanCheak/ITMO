package Md2Html;

public class Caption {
    private StringBuilder primordial;
    private int lvl;
    Caption(StringBuilder primordial) {
        this.primordial = primordial;
        lvl = 0;
        while (lvl < primordial.length() && primordial.charAt(lvl) == '#') {
            lvl++;
        }
    }
    void toHtml(StringBuilder ans) {
        ans.append('<').append('h').append(lvl).append('>');
        new Text(new StringBuilder(primordial.substring(lvl + 1))).toHtml(ans);
        ans.append('<').append('/').append('h').append(lvl).append('>');
    }
}

