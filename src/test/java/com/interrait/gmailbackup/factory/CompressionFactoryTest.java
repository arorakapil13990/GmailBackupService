package com.interrait.gmailbackup.factory;

import static org.junit.Assert.*;
import org.junit.Test;

import com.interrait.gmailbackup.compressionstrategy.CompressionStrategy;
import com.interrait.gmailbackup.compressionstrategy.ZipCompression;
import com.interrait.gmailbackup.enums.Compression;

public class CompressionFactoryTest {

	
	@Test
	public void testCompressionStrategy(){
		CompressionStrategy strategy = CompressionFactory.getCompressionStrategy(Compression.ZIP);
		assertEquals(ZipCompression.class, strategy.getClass());		
	}
}
