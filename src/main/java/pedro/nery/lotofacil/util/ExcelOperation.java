package pedro.nery.lotofacil.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class ExcelOperation {

	public static InputStream getPlanilha(CloseableHttpClient client) throws Exception {

		// link da pagina
		HttpPost httpPost = new HttpPost("https://asloterias.com.br/download_excel.php");

		// parametros (que sao hidden)
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("l", "lf"));
		params.add(new BasicNameValuePair("t", "t"));
		// C para crescente e S para sorte do Sorteio
		params.add(new BasicNameValuePair("o", "c"));
		params.add(new BasicNameValuePair("f1", ""));
		params.add(new BasicNameValuePair("f2", ""));

		httpPost.setEntity(new UrlEncodedFormEntity(params));

		CloseableHttpResponse response = client.execute(httpPost);

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			return entity.getContent();
		} else
			return null;

	}
}
