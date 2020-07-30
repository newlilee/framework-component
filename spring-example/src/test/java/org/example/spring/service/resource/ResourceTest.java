package org.example.spring.service.resource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.*;

/**
 * @author clx 2017年5月13日 下午3:37:04
 */
public class ResourceTest {

	@Test
	public void testByteArrayResource() {
		// define resource
		Resource resource = new ByteArrayResource("Hello, World".getBytes());

		// verify resource existed?
		if (resource.exists()) {
			// use resource
			dumpResource(resource);
		}
	}

	@Test
	public void testInputStreamResource() {
		ByteArrayInputStream bais = new ByteArrayInputStream("Hello, World".getBytes());
		Resource resource = new InputStreamResource(bais);

		if (resource.exists()) {
			dumpResource(resource);
		}
		Assert.assertEquals(true, resource.isOpen());
	}

	@Test
	public void testFileSystemResource() {
		File file = new File("F:\\Documents\\Password.txt");
		Resource resource = new FileSystemResource(file);
		if (resource.exists()) {
			dumpResource(resource);
		}
		Assert.assertEquals(false, resource.isOpen());
	}

	@Test
	public void testClassPathResourceByDefClassLoader() throws Exception {
		Resource resource = new ClassPathResource("com.spring.basic.service/test.properties");
		if (resource.exists()) {
			dumpResource(resource);
		}
		System.out.println("file path:" + resource.getFile().getAbsolutePath());
		Assert.assertEquals(false, resource.isOpen());
	}

	@Test
	public void testClassPathResourceByClassLoader() throws IOException {
		ClassLoader loader = this.getClass().getClassLoader();
		Resource resource = new ClassPathResource("com.spring.basic.service/test.properties", loader);
		if (resource.exists()) {
			dumpResource(resource);
		}
		System.out.println("File path:" + resource.getFile().getAbsolutePath());
		Assert.assertEquals(false, resource.isOpen());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testClassPathResourceByClass() throws IOException {
		Class clazz = this.getClass();
		Resource resource = new ClassPathResource("test.properties", clazz);
		if (resource.exists()) {
			dumpResource(resource);
		}
		System.out.println("File path:" + resource.getFile().getAbsolutePath());
		Assert.assertEquals(false, resource.isOpen());
	}

	@Test
	public void testUrlResource() throws Exception {
		Resource resource = new UrlResource("file:///F:\\Documents\\Password.txt");
		if (resource.exists()) {
			dumpResource(resource);
		}
		System.out.println("file path:" + resource.getURL().getPath());
		Assert.assertEquals(false, resource.isOpen());
	}

	private void dumpResource(Resource resource) {
		// open resource
		InputStream in = null;
		try {
			// read resource
			in = resource.getInputStream();
			byte[] resBytes = new byte[in.available()];
			in.read(resBytes);
			System.out.println(new String(resBytes));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// close resource
			try {
				in.close();
			} catch (IOException e) {

			}
		}
	}
}
