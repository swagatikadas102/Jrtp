package in.ashokit.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.Searchrequest.SearchRequest;
import in.ashokit.Service.ReportService;
import in.ashokit.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RestController {


	@Autowired
	private ReportService service;
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition","attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition","attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	@PostMapping("/searchData")
	public String handleSearch(SearchRequest search,Model model) {
		List<CitizenPlan> plans = service.search(search);
		model.addAttribute("plans",plans);
		model.addAttribute("search",search);
		init(model);
		return "index";
		 
	}
	@InitBinder
	public void myDateBinder(WebDataBinder binder) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}
	
	@GetMapping("/")
	public String indexPage(Model model) {
		SearchRequest searchobj = new SearchRequest();
		model.addAttribute("search",searchobj);
		init(model);
		return "index";
 }
	private void init(Model model) {
		model.addAttribute("names",service.getPlanName());
		model.addAttribute("status",service.getPlanstatus());
	}
}
