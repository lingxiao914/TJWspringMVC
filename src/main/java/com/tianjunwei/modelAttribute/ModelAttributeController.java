/**
 *    Copyright  2016  tianjunwei
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.tianjunwei.modelAttribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tianjunwei
 * @time 2016 上午10:31:35
 */
@Controller
public class ModelAttributeController {
	
	@ModelAttribute
	public void init(Model model){
		model.addAttribute("test", "测试信息");
	}
	
	@RequestMapping("/modelAttribute")
	public String modelAttribute(Model model,@ModelAttribute("test3")String test3){
		model.addAttribute("test1", "测试信息1");
		model.addAttribute("test3", test3);
		return "modelAttribute";
	}
	
}
