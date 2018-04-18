package com.simply.zuozuo.util;


import java.util.Properties;

/**
 * @author Created by 谭健 on 2018/4/16 0016. 星期一. 15:36.
 * © All Rights Reserved.
 */

public class SystemPropertieUtils {


    public static String getSunCpuIsalist() {
        return System.getProperty("sun.cpu.isalist");
    }

    public static String getSunDesktop() {
        return System.getProperty("sun.desktop");
    }

    public static String getSunIoUnicodeEncoding() {
        return System.getProperty("sun.io.unicode.encoding");
    }

    public static String getSunCpuEndian() {
        return System.getProperty("sun.cpu.endian");
    }

    public static String getJavaVendorUrlBug() {
        return System.getProperty("java.vendor.url.bug");
    }

    public static String getFileSeparator() {
        return System.getProperty("file.separator");
    }

    public static String getJavaVendor() {
        return System.getProperty("java.vendor");
    }

    public static String getSunBootClassPath() {
        return System.getProperty("sun.boot.class.path");
    }

    public static String getJavaExtDirs() {
        return System.getProperty("java.ext.dirs");
    }

    public static String getJavaVersion() {
        return System.getProperty("java.version");
    }

    public static String getJavaVmInfo() {
        return System.getProperty("java.vm.info");
    }

    public static String getAwtToolkit() {
        return System.getProperty("awt.toolkit");
    }

    public static String getUserLanguage() {
        return System.getProperty("user.language");
    }

    public static String getJavaSpecificationVendor() {
        return System.getProperty("java.specification.vendor");
    }

    public static String getSunJavaCommand() {
        return System.getProperty("sun.java.command");
    }

    public static String getJavaHome() {
        return System.getProperty("java.home");
    }

    public static String getSunArchDataModel() {
        return System.getProperty("sun.arch.data.model");
    }

    public static String getJavaVmSpecificationVersion() {
        return System.getProperty("java.vm.specification.version");
    }

    public static String getJavaClassPath() {
        return System.getProperty("java.class.path");
    }

    public static String getUserName() {
        return System.getProperty("user.name");
    }

    public static String getFileEncoding() {
        return System.getProperty("file.encoding");
    }

    public static String getJavaSpecificationVersion() {
        return System.getProperty("java.specification.version");
    }

    public static String getJavaAwtPrinterjob() {
        return System.getProperty("java.awt.printerjob");
    }

    public static String getUserTimezone() {
        return System.getProperty("user.timezone");
    }

    public static String getUserHome() {
        return System.getProperty("user.home");
    }

    public static String getOsVersion() {
        return System.getProperty("os.version");
    }

    public static String getSunManagementCompiler() {
        return System.getProperty("sun.management.compiler");
    }

    public static String getJavaSpecificationName() {
        return System.getProperty("java.specification.name");
    }

    public static String getJavaClassVersion() {
        return System.getProperty("java.class.version");
    }

    public static String getJavaLibraryPath() {
        return System.getProperty("java.library.path");
    }

    public static String getSunJnuEncoding() {
        return System.getProperty("sun.jnu.encoding");
    }

    public static String getOsName() {
        return System.getProperty("os.name");
    }

    public static String getUserVariant() {
        return System.getProperty("user.variant");
    }

    public static String getJavaVmSpecificationVendor() {
        return System.getProperty("java.vm.specification.vendor");
    }

    public static String getJavaIoTmpdir() {
        return System.getProperty("java.io.tmpdir");
    }

    public static String getLineSeparator() {
        return System.getProperty("line.separator");
    }

    public static String getJavaEndorsedDirs() {
        return System.getProperty("java.endorsed.dirs");
    }

    public static String getOsArch() {
        return System.getProperty("os.arch");
    }

    public static String getJavaAwtGraphicsenv() {
        return System.getProperty("java.awt.graphicsenv");
    }

    public static String getJavaRuntimeVersion() {
        return System.getProperty("java.runtime.version");
    }

    public static String getJavaVmSpecificationName() {
        return System.getProperty("java.vm.specification.name");
    }

    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    public static String getUserCountry() {
        return System.getProperty("user.country");
    }

    public static String getUserScript() {
        return System.getProperty("user.script");
    }

    public static String getSunJavaLauncher() {
        return System.getProperty("sun.java.launcher");
    }

    public static String getSunOsPatchLevel() {
        return System.getProperty("sun.os.patch.level");
    }

    public static String getJavaVmName() {
        return System.getProperty("java.vm.name");
    }

    public static String getFileEncodingPkg() {
        return System.getProperty("file.encoding.pkg");
    }

    public static String getPathSeparator() {
        return System.getProperty("path.separator");
    }

    public static String getJavaVmVendor() {
        return System.getProperty("java.vm.vendor");
    }

    public static String getJavaVendorUrl() {
        return System.getProperty("java.vendor.url");
    }

    public static String getSunBootLibraryPath() {
        return System.getProperty("sun.boot.library.path");
    }

    public static String getJavaVmVersion() {
        return System.getProperty("java.vm.version");
    }

    public static String getJavaRuntimeName() {
        return System.getProperty("java.runtime.name");
    }


    public static void setSunCpuIsalist(String value) {
        System.setProperty("sun.cpu.isalist", value);
    }

    public static void setSunDesktop(String value) {
        System.setProperty("sun.desktop", value);
    }

    public static void setSunIoUnicodeEncoding(String value) {
        System.setProperty("sun.io.unicode.encoding", value);
    }

    public static void setSunCpuEndian(String value) {
        System.setProperty("sun.cpu.endian", value);
    }

    public static void setJavaVendorUrlBug(String value) {
        System.setProperty("java.vendor.url.bug", value);
    }

    public static void setFileSeparator(String value) {
        System.setProperty("file.separator", value);
    }

    public static void setJavaVendor(String value) {
        System.setProperty("java.vendor", value);
    }

    public static void setSunBootClassPath(String value) {
        System.setProperty("sun.boot.class.path", value);
    }

    public static void setJavaExtDirs(String value) {
        System.setProperty("java.ext.dirs", value);
    }

    public static void setJavaVersion(String value) {
        System.setProperty("java.version", value);
    }

    public static void setJavaVmInfo(String value) {
        System.setProperty("java.vm.info", value);
    }

    public static void setAwtToolkit(String value) {
        System.setProperty("awt.toolkit", value);
    }

    public static void setUserLanguage(String value) {
        System.setProperty("user.language", value);
    }

    public static void setJavaSpecificationVendor(String value) {
        System.setProperty("java.specification.vendor", value);
    }

    public static void setSunJavaCommand(String value) {
        System.setProperty("sun.java.command", value);
    }

    public static void setJavaHome(String value) {
        System.setProperty("java.home", value);
    }

    public static void setSunArchDataModel(String value) {
        System.setProperty("sun.arch.data.model", value);
    }

    public static void setJavaVmSpecificationVersion(String value) {
        System.setProperty("java.vm.specification.version", value);
    }

    public static void setJavaClassPath(String value) {
        System.setProperty("java.class.path", value);
    }

    public static void setUserName(String value) {
        System.setProperty("user.name", value);
    }

    public static void setFileEncoding(String value) {
        System.setProperty("file.encoding", value);
    }

    public static void setJavaSpecificationVersion(String value) {
        System.setProperty("java.specification.version", value);
    }

    public static void setJavaAwtPrinterjob(String value) {
        System.setProperty("java.awt.printerjob", value);
    }

    public static void setUserTimezone(String value) {
        System.setProperty("user.timezone", value);
    }

    public static void setUserHome(String value) {
        System.setProperty("user.home", value);
    }

    public static void setOsVersion(String value) {
        System.setProperty("os.version", value);
    }

    public static void setSunManagementCompiler(String value) {
        System.setProperty("sun.management.compiler", value);
    }

    public static void setJavaSpecificationName(String value) {
        System.setProperty("java.specification.name", value);
    }

    public static void setJavaClassVersion(String value) {
        System.setProperty("java.class.version", value);
    }

    public static void setJbossModulesSystemPkgs(String value) {
        System.setProperty("jboss.modules.system.pkgs", value);
    }

    public static void setJavaLibraryPath(String value) {
        System.setProperty("java.library.path", value);
    }

    public static void setSunJnuEncoding(String value) {
        System.setProperty("sun.jnu.encoding", value);
    }

    public static void setOsName(String value) {
        System.setProperty("os.name", value);
    }

    public static void setUserVariant(String value) {
        System.setProperty("user.variant", value);
    }

    public static void setJavaVmSpecificationVendor(String value) {
        System.setProperty("java.vm.specification.vendor", value);
    }

    public static void setJavaIoTmpdir(String value) {
        System.setProperty("java.io.tmpdir", value);
    }

    public static void setLineSeparator(String value) {
        System.setProperty("line.separator", value);
    }

    public static void setJavaEndorsedDirs(String value) {
        System.setProperty("java.endorsed.dirs", value);
    }

    public static void setOsArch(String value) {
        System.setProperty("os.arch", value);
    }

    public static void setJavaAwtGraphicsenv(String value) {
        System.setProperty("java.awt.graphicsenv", value);
    }

    public static void setJavaRuntimeVersion(String value) {
        System.setProperty("java.runtime.version", value);
    }

    public static void setJavaVmSpecificationName(String value) {
        System.setProperty("java.vm.specification.name", value);
    }

    public static void setUserDir(String value) {
        System.setProperty("user.dir", value);
    }

    public static void setUserCountry(String value) {
        System.setProperty("user.country", value);
    }

    public static void setUserScript(String value) {
        System.setProperty("user.script", value);
    }

    public static void setSunJavaLauncher(String value) {
        System.setProperty("sun.java.launcher", value);
    }

    public static void setSunOsPatchLevel(String value) {
        System.setProperty("sun.os.patch.level", value);
    }

    public static void setJavaVmName(String value) {
        System.setProperty("java.vm.name", value);
    }

    public static void setFileEncodingPkg(String value) {
        System.setProperty("file.encoding.pkg", value);
    }

    public static void setPathSeparator(String value) {
        System.setProperty("path.separator", value);
    }

    public static void setJavaVmVendor(String value) {
        System.setProperty("java.vm.vendor", value);
    }

    public static void setJavaVendorUrl(String value) {
        System.setProperty("java.vendor.url", value);
    }

    public static void setSunBootLibraryPath(String value) {
        System.setProperty("sun.boot.library.path", value);
    }

    public static void setJavaVmVersion(String value) {
        System.setProperty("java.vm.version", value);
    }

    public static void setJavaRuntimeName(String value) {
        System.setProperty("java.runtime.name", value);
    }

    public static void main(String[] args) {
        fast();

    }

    private static void print() {
        Print.echo(getSunCpuIsalist());
        Print.echo(getSunDesktop());
        Print.echo(getSunIoUnicodeEncoding());
        Print.echo(getSunCpuEndian());
        Print.echo(getJavaVendorUrlBug());
        Print.echo(getFileSeparator());
        Print.echo(getJavaVendor());
        Print.echo(getSunBootClassPath());
        Print.echo(getJavaExtDirs());
        Print.echo(getJavaVersion());
        Print.echo(getJavaVmInfo());
        Print.echo(getAwtToolkit());
        Print.echo(getUserLanguage());
        Print.echo(getJavaSpecificationVendor());
        Print.echo(getSunJavaCommand());
        Print.echo(getJavaHome());
        Print.echo(getSunArchDataModel());
        Print.echo(getJavaVmSpecificationVersion());
        Print.echo(getJavaClassPath());
        Print.echo(getUserName());
        Print.echo(getFileEncoding());
        Print.echo(getJavaSpecificationVersion());
        Print.echo(getJavaAwtPrinterjob());
        Print.echo(getUserTimezone());
        Print.echo(getUserHome());
        Print.echo(getOsVersion());
        Print.echo(getSunManagementCompiler());
        Print.echo(getJavaSpecificationName());
        Print.echo(getJavaClassVersion());
        Print.echo(getJavaLibraryPath());
        Print.echo(getSunJnuEncoding());
        Print.echo(getOsName());
        Print.echo(getUserVariant());
        Print.echo(getJavaVmSpecificationVendor());
        Print.echo(getJavaIoTmpdir());
        Print.echo(getLineSeparator());
        Print.echo(getJavaEndorsedDirs());
        Print.echo(getOsArch());
        Print.echo(getJavaAwtGraphicsenv());
        Print.echo(getJavaRuntimeVersion());
        Print.echo(getJavaVmSpecificationName());
        Print.echo(getUserDir());
        Print.echo(getUserCountry());
        Print.echo(getUserScript());
        Print.echo(getSunJavaLauncher());
        Print.echo(getSunOsPatchLevel());
        Print.echo(getJavaVmName());
        Print.echo(getFileEncodingPkg());
        Print.echo(getPathSeparator());
        Print.echo(getJavaVmVendor());
        Print.echo(getJavaVendorUrl());
        Print.echo(getSunBootLibraryPath());
        Print.echo(getJavaVmVersion());
        Print.echo(getJavaRuntimeName());
    }

    private static void fast() {
        Properties properties = System.getProperties();
        properties.forEach((o, o2) -> {

            String var = o.toString();
            char[] vars = var.toCharArray();
            String varName = "";
            for (int i = 0; i < vars.length; i++) {
                if (i == 0) {
                    varName += String.valueOf(vars[i]).toUpperCase();
                    continue;
                }
                if (vars[i] == '.') continue;
                if (i > 0 && vars[i - 1] == '.') {
                    varName += String.valueOf(vars[i]).toUpperCase();
                    continue;
                }
                varName += String.valueOf(vars[i]);

            }


            //  Print.echo(varName);
            //  Print.echo("public static String get" + varName + "(){ return System.getProperty(\"" + var + "\");}");
            //  Print.echo("Print.echo(get" + varName + "());");
            //  Print.echo("public static void set" + varName + "(String value){ System.setProperty(\"" + var + "\",value);}");
        });
    }
}
