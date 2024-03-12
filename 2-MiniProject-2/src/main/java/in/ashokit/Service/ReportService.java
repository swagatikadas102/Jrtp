package in.ashokit.Service;

import java.util.List;

import in.ashokit.Searchrequest.SearchRequest;
import in.ashokit.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {

	public List<String> getPlanName();
	public List<String> getPlanstatus();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean exportExcel(HttpServletResponse res)throws Exception;
	public boolean exportPdf(HttpServletResponse res)throws Exception;
	
}
