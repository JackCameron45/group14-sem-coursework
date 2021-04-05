package interaction;

public class Startup {

    private long id;
    private String content;

    public void Greeting(long id, String content)
    {
        this.id = id;
        this.content = content;
    }

    public Startup(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
