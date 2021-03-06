package com.example.demo.snowflak;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @author chenlingl
 * @version 1.0
 * @date 2022/1/17 15:55
 */
public class IpUtil {


    public static boolean isWindowsOS() {

        boolean isWindowsOS = false;

        String osName = System.getProperty("os.name");

        if (osName.toLowerCase().indexOf("windows") > -1) {

            isWindowsOS = true;
        }

        return isWindowsOS;

    }


    /**
     *
     * 获取本机ip地址，并自动区分Windows还是linux操作系统
     *
     * @return String
     * @throws UnknownHostException
     * @throws SocketException
     *
     */

    public static String getLocalIP() throws UnknownHostException, SocketException {

        String sIP = "";

        InetAddress ip = null;

        if (isWindowsOS()) {

            ip = InetAddress.getLocalHost();

        } else { // 如果是Linux操作系统


            boolean bFindIP = false;

            Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();

            while (netInterfaces.hasMoreElements()) {

                if (bFindIP) {

                    break;
                }

                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();

                // ----------特定情况，可以考虑用ni.getName判断

                // 遍历所有ip
                Enumeration<InetAddress> ips = ni.getInetAddresses();

                while (ips.hasMoreElements()) {

                    ip = (InetAddress) ips.nextElement();

                    if (ip.isSiteLocalAddress()

                            && !ip.isLoopbackAddress() // 127.开头的都是lookback地址

                            && ip.getHostAddress().indexOf(":") == -1) {

                        bFindIP = true;

                        break;

                    }
                }
            }
        }
        if (null != ip) {

            sIP = ip.getHostAddress();

        }

        return sIP;

    }
}
