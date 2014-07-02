package gh.funthomas424242.lib.jbehave;

import java.io.File;

public class PagePfadBuilder {

    public String getLocalPathPräfix() {
        final String userDir = System.getProperty("user.dir");
        final String testDir = userDir + File.separator + "src"
                + File.separator + "main" + File.separator + "webapp"
                + File.separator;
        return "file:///" + testDir;
    }

    public String getRemotePathPräfix() {
        return "http://localhost:8080/webapp.example/";
    }

}
