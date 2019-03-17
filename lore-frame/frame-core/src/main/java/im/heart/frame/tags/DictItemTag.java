
package im.heart.frame.tags;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;

@Component
public class DictItemTag extends SimpleHash {


	public DictItemTag() {
		super(new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_24).build());
		put("dict", new FrameDictItemTag());
	}
}
