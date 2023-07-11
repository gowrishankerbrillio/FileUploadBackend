package com.fileStorage.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileStorage.entity.FileEntity;
import com.fileStorage.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	private FileRepository repository;

	public void saveFile(MultipartFile file) {
		String line;
		String[] data = null;
		try {
			InputStream input = file.getInputStream();
			BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(input));

			while ((line = bufferedReader.readLine()) != null) {
				data = line.split(",");
				int snoIndex = Arrays.asList(data).lastIndexOf("s.no");
				int dataInfoIndex = Arrays.asList(data).lastIndexOf("DATA_INFO");
				int costInfoIndex = Arrays.asList(data).lastIndexOf("COST_INFO");

				while ((line = bufferedReader.readLine()) != null) {
					data = line.split(",");
					String dataInfo = Arrays.asList(data).get(dataInfoIndex);
					int costInfo = Integer.parseInt(Arrays.asList(data).get(costInfoIndex));
					FileEntity entity = new FileEntity();
					entity.setId(snoIndex);
					entity.setDataInfo(dataInfo);
					entity.setCostInfo(costInfo);
					repository.save(entity);
				}
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
