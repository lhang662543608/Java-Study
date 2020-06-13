package flyweight;

import java.util.Hashtable;

/**
 * 抽象工厂----多媒体文件工厂
 */
public class MultimediaFileFactory {
    private Hashtable<String, MultimediaFile> ht;
    private int fileNum = 0;

    public MultimediaFileFactory() {
        ht = new Hashtable<String, MultimediaFile>();
        ht.put("Image", new Image());
        ht.put("Animation", new Animation());
        ht.put("Video", new Video());
    }

    public MultimediaFile getMultimediaFile(String fileName) {
        if (ht.containsKey(fileName)) {
            fileNum++;
            return ht.get(fileName);
        } else {
            throw new RuntimeException("没有此类型");
        }
    }

    public int getFileNum() {
        return fileNum;
    }
}
