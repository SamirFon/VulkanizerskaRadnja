package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;
import auto_radnja.Radnja;
import auto_radnja.RadnjaTest;


public class VulkanizerskaRadnjaTest extends RadnjaTest {
	



	@BeforeEach
	void setUp() throws Exception {
		vk = new VulkanizerskaRadnja();
	}

	@AfterEach
	void tearDown() throws Exception {
		vk = null;
	}

	
}
