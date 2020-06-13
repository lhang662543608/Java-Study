package flyweight;

/**
 * 某软件公司要开发一个多功能文档编辑器，在文本文档中可以插入图片、动画、视频等多媒体资料。
 * 为了节约系统资源，相同的图片、视频和动画在同一个文档值保存一份，但是可以多次同时出现，
 * 而且它们每次出现的位置和大小均可不同。
 * 试使用享元模式设计该文档编辑器。
 */
public class Client {
    public static void main(String[] args) {
        MultimediaFileFactory fileFactory = new MultimediaFileFactory();
        int fileNum = fileFactory.getFileNum();
        System.out.println(fileNum);//0

        MultimediaFile image = fileFactory.getMultimediaFile("Image");
        MultimediaFile image1 = fileFactory.getMultimediaFile("Image");

        image.setLocation(new Location(12, 23));
        image.setSize(new Size(12, 45));
        image.display();//flyweight.Image@6ff3c5b5size：Size{width=12, height=45}location:Location{x=12, y=23}

        image1.setSize(new Size(42, 15));
        image1.setLocation(new Location(42, 13));
        image1.display();//flyweight.Image@6ff3c5b5size：Size{width=42, height=15}location:Location{x=42, y=13}

        System.out.println(image == image1);//true

        fileNum = fileFactory.getFileNum();
        System.out.println(fileNum);//2
    }
}

