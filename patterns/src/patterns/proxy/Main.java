package patterns.proxy;

public class Main {

	public static void main(String[] args) {
		FilterDownloader memory = new FilterDownloader(new Filter());
		FilterDownloader cache = new FilterDownloader(new IpProxyCache());

		long memTime = getTime(memory);
		long cacheTime = getTime(cache);
		System.out.println("Different: " + (memTime - cacheTime));
	}

	private static long getTime(FilterDownloader downloader) {
		long startTime = System.nanoTime();

		downloader.createPoolIp();
		downloader.getPordByIp("127.0.0.1");

		long resTime = System.nanoTime() - startTime;

		System.out.println("Time all: " + resTime + " nanos" + System.lineSeparator());
		return resTime;

	}
}
