package prim.hugescrub.staxparsing;

public abstract class AbstractParser implements XmlParser {

    protected String filename = null;

    public AbstractParser(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
