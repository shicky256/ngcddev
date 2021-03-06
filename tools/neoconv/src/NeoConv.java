public class NeoConv {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: neoconv [-i image.bmp] [-m map.tmx]");
            return;
        }
        Converter converter = new Converter();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i")) {
                String imgStr = args[i+1];
//                converter.writeImage(args[i + 1].substring(0, args[i + 1].indexOf('.')) + ".spr");
                converter.addImage(imgStr);
                converter.writePalette(imgStr, imgStr.substring(imgStr.lastIndexOf('\\') + 1, imgStr.lastIndexOf('.')) + ".pal");
                i++;
            }
            else if (args[i].equals("-m")) {
                String mapStr = args[i+1];
                MapReader mapReader = new MapReader(mapStr);

                mapReader.outputMap(mapStr.substring(mapStr.lastIndexOf('\\') + 1, mapStr.lastIndexOf('.')) + ".map");
                i++;
            }
        }
        converter.writeImages("out.spr");
    }
}
