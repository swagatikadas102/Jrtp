package in.ashokit.Service;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.ashokit.Searchrequest.SearchRequest;
import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public List<String> getPlanName() {
		return repo.getPlanName();
	}

	@Override
	public List<String> getPlanstatus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		

		CitizenPlan cp = new CitizenPlan();
		
		if(null != request.getPlanname() && ""!= request.getPlanstatus()) {
			cp.setPlan_name(request.getPlanname());
		}
		if(null != request.getPlanstatus() && "" != request.getPlanstatus()) {
			cp.setPlan_status(request.getPlanstatus());
		}
		if(null != request.getGender() && "" != request.getGender()) {
			cp.setGender(request.getGender());
		}
		if(null != request.getStartdate() && !"".equals(request.getStartdate())) {
			cp.setGender(request.getGender());
		}
		if(null!= request.getEnddate() && !"".equals(request.getEnddate())) {
			cp.setPlan_end_date(request.getEnddate());
		}
		List<CitizenPlan> findAll = repo.findAll(Example.of(cp));
		findAll.forEach(System.out::println);
		return findAll;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
	
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook .createSheet("Plans-data");
		Row headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Plan Start Date");
		headerRow.createCell(6).setCellValue("Plan End Date");
		headerRow.createCell(7).setCellValue("Benifit Amount");
		
		List<CitizenPlan> records = repo.findAll();
		
		int dataRowIndex=1;
		
		for (CitizenPlan plan : records) {
		Row dataRow = sheet.createRow(dataRowIndex);
		dataRow.createCell(0).setCellValue(plan.getCitizen_id());
		dataRow.createCell(1).setCellValue(plan.getCitizen_name());
		dataRow.createCell(2).setCellValue(plan.getGender());
		dataRow.createCell(3).setCellValue(plan.getPlan_name());
		dataRow.createCell(4).setCellValue(plan.getPlan_status());
		dataRow.createCell(5).setCellValue(plan.getPlan_start_date()+"");
		dataRow.createCell(6).setCellValue(plan.getPlan_end_date()+"");
		
		if(null != plan.getBenifit_amount()) {
		      dataRow.createCell(7).setCellValue(plan.getBenifit_amount());
		}else {
			dataRow.createCell(7).setCellValue("N/A");
		}
		
		dataRowIndex++;
		}
		
		ServletOutputStream outputStream =response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response)throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document,response.getOutputStream());
		document.open();
		Paragraph p = new Paragraph("Citizen Plans Info");
		document.add(p);
		
		PdfPTable table = new PdfPTable(7);
		
		table.addCell("Id");
		table.addCell("CitizenName");
		table.addCell("Gender");
		table.addCell("PlanName");
		table.addCell("PlanStatus");
		table.addCell("StartDate");
		table.addCell("EndDate");
		
		
		List<CitizenPlan> plans = repo.findAll();
		
		for(CitizenPlan plan :plans) {
			table.addCell(String.valueOf(plan.getCitizen_id()));
			table.addCell(plan.getCitizen_name());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlan_name());
			table.addCell(plan.getPlan_status());
			table.addCell(plan.getPlan_start_date()+"");
			table.addCell(plan.getPlan_end_date()+ "");
			
			
		}
		document.add(table);
		
		document.close();
		return true;
	}

}
 