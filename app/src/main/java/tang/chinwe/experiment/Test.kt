package tang.chinwe.experiment

fun main() {
    var appidpars="com.yestube.downloader.plugin".split(".")
    var stringBuffer=StringBuffer()
    appidpars.forEach {
        if(!it.equals("plugin")){
            stringBuffer.append(it).append(".");
        }
    }
    var result= stringBuffer.deleteCharAt(stringBuffer.length-1).toString();
}