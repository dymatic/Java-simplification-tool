package libsubject;

import java.io.IOException;

/**
 * Contains the "other" stuff that LibMath and LibText didn't cover. Computer
 * related methods will be going in here.
 *
 * @author nate
 */
public abstract class LibVarious {
    /*
     * For most of the property accessors below, huge thanks to
     * http://www.java2s.com/Tutorial/Java/0120__Development/Javasystemproperties.htm
     *
     */

    /**
     * Finds the version of Java the user is using.
     *
     * @return version of java.
     */
    public static String getJavaVersion() {
        return System.getProperty("java.version");
    }

    /**
     * Finds the Java Runtime Environment vendor the user is using.
     *
     * @return JRE vendor
     */
    public static String getJreVendor() {
        return System.getProperty("java.vendor");
    }

    /**
     * Returns the URL for the Java Runtime Environment vendor. To find the Java
     * Runtime Environment vendor, use getJreVendor
     *
     * @return JRE vendor url.
     */
    public static String getJreVendorUrl() {
        return System.getProperty("java.vendor.url");
    }

    /**
     * Returns the name of the directory where java is installed.
     *
     * @return java directory
     */
    public static String getJavaDirectory() {
        return System.getProperty("java.home");
    }

    /**
     * Returns the Java Virtual Machine Specification version.
     *
     * @return JVM specification version
     */
    public static String getJvmSpecificationVersion() {
        return System.getProperty("java.vm.specification.version");
    }

    /**
     * Returns the Java Virtual Machine Specification vendor.
     *
     * @return JVM specification vendor
     */
    public static String getJvmSpecificationVendor() {
        return System.getProperty("java.vm.specification.vendor");
    }

    /**
     * Returns the name of the Java virtual machine.
     *
     * @return JVM name
     */
    public static String getJvmSpecificationName() {
        return System.getProperty("java.vm.specification.name");
    }

    /**
     * Returns the version of the JVM.
     *
     * @return JVM version
     */
    public static String getJvmVersion() {
        return System.getProperty("java.vm.version");
    }

    /**
     * Returns the vendor for the implemented JVM.
     *
     * @return JVM vendor
     */
    public static String getJvmVendor() {
        return System.getProperty("java.vm.vendor");
    }

    /**
     * Returns the name for the implemented JVM.
     *
     * @return JVM name
     */
    public static String getJvmName() {
        return System.getProperty("java.vm.name");
    }

    /**
     * Returns the name of the Java Runtime Environment Specification Version
     *
     * @return JRE specification version
     */
    public static String getJreSpecificationVersion() {
        return System.getProperty("java.specification.version");
    }

    /**
     * Returns the name of the Java runtime environment specification vendor.
     *
     * @return JRE specification vendor
     */
    public static String getJreSpecificationVendor() {
        return System.getProperty("java.specification.vendor");
    }

    /**
     * Returns the Java Runtime Environment specification name.
     *
     * @return JRE specification name
     */
    public static String getJreSpecificationName() {
        return System.getProperty("java.specification.name");
    }

    /**
     * Gets the Class format version number.
     *
     * @return Class format version number
     */
    public static String getClassFormatVersion() {
        return System.getProperty("java.class.version");
    }

    /**
     * Returns the java class path.
     *
     * @return Java class path
     */
    public static String getJavaClassPath() {
        return System.getProperty("java.class.path");
    }

    /**
     * Returns the path that is used when loading libraries.
     *
     * @return library path
     */
    public static String getLibraryPath() {
        return System.getProperty("java.library.path");
    }

    /**
     * Returns the System's temporary directory, where data is stored for a
     * limited time before being deleted.
     *
     * @return temporary directory path
     */
    public static String getTemporaryDirectory() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     * Returns the JIT compiler that will be used.
     *
     * @return the compiler
     */
    public static String getCompiler() {
        return System.getProperty("java.compiler");
    }

    /**
     * Returns the name of the extension directory(s)
     *
     * @return extension directories
     */
    public static String getExtensionDirectoryPath() {
        return System.getProperty("java.ext.dirs");
    }

    /**
     * Returns the name of the operating system.
     *
     * @return OS name
     */
    public static String getOperatingSystemName() {
        return System.getProperty("os.name");
    }

    /**
     * Returns the architecture of the operating system. It's noteworthy that
     * this and the processor architecture may be different.
     *
     * @return OS arch
     */
    public static String getOperatingSystemArchitecture() {
        return System.getProperty("os.arch");
    }

    /**
     * Returns the version of the operating system. On Linux systems this
     * returns the version of the Linux kernel.
     *
     * @return OS version
     */
    public static String getOperatingSystemVersion() {
        return System.getProperty("os.version");
    }

    /**
     * Returns the file separator used by this operating system.
     *
     * @return file seperator
     */
    public static String getFileSeparator() {
        return System.getProperty("file.separator");
    }

    /**
     * Returns the path separator
     *
     * @return path separator
     */
    public static String getPathSeparator() {
        return System.getProperty("path.separator");
    }

    /**
     * Returns the line separator. That is, the character that begins a new
     * line. '\n' is common.
     *
     * @return line separator
     */
    public static String getLineSeparator() {
        return System.getProperty("line.separator");
    }

    /**
     * Returns the username of the currently logged in user.
     *
     * @return username
     */
    public static String getUserName() {
        return System.getProperty("user.name");
    }

    /**
     * Gets the user's home directory.
     *
     * @return home directory path
     */
    public static String getUserDirectory() {
        return System.getProperty("user.home");
    }

    /**
     * Returns the working directory for the logged in user.
     *
     * @return working directory path
     */
    public static String getUserWorkingDirectory() {
        return System.getProperty("user.dir");
    }

    /**
     * Executes a command from the system shell.
     *
     * @param The command to execute
     * @throws IOException
     */
    public static void execute(String exec) throws IOException {
        Runtime.getRuntime().exec(exec);
    }
}//End of class
