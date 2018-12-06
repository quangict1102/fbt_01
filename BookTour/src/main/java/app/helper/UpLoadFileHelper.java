package app.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

public class UpLoadFileHelper {
	private static final Logger logger = Logger.getLogger(UpLoadFileHelper.class);

	public static Cloudinary startCloudinary(String cloudName, String apiKey, String apiSecret) {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", cloudName, "api_key", apiKey, "api_secret", apiSecret));

	}

	public static String upFile(MultipartFile file, String cloudName, String apiKey, String apiSecret) {
		File convFile = new File(file.getOriginalFilename());
		Map uploadResult = null;
		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
			uploadResult = startCloudinary(cloudName, apiKey, apiSecret).uploader().upload(convFile,
					ObjectUtils.emptyMap());
		} catch (Exception e) {
			logger.error(e);
		}
		return uploadResult.get("public_id").toString();

	}

	public static String loadFile(String publicId, String cloudName, String apiKey, String apiSecret) {
		String url = startCloudinary(cloudName, apiKey, apiSecret).url().format("jpg")
				.transformation(new Transformation().width(250).height(168).crop("fit")).generate(publicId);
		return url;

	}

}
