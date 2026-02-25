package com.alaa.parfum.service;

import java.util.List;
import com.alaa.repos.ParfumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.alaa.entities.Parfum;
@Service
public class ParfumServiceelmpl implements ParfumService {
    @Autowired
	ParfumRepository ParfumRepository;
	
	@Override
	public Parfum saveParfum(Parfum p) {
		return ParfumRepository.save(p);
	}

	@Override
	public Parfum updateParfum(Parfum p) {
		return ParfumRepository.save(p);
	}

	@Override
	public void deleteParfum(Parfum p) {
		ParfumRepository.delete(p);
		
	}
    @Override
	public void deleteParfumById(Long id) {
		ParfumRepository.deleteById(id);
		
	}

	@Override
	public Parfum getParfum(Long id) {
		return ParfumRepository.findById(id).get();
	}

	@Override
	public List<Parfum> getAllParfums() {
		
		return ParfumRepository.findAll();
	}

    @Test
     public void testFindByNomParfumContains()
    { ParfumService parfumService;

Page<Parfum> p = parfumService.getAllParfumsParPage(0,2);
System.out.println(p.getSize());
System.out.println(p.getTotalElements()); System.out.println(p.getTotalPages());
p.getContent().forEach(p-> {System.out.println(p.toString());
});
/*ou bien
for (Parfum p : prods)
{
System.out.println(p);
} */
}

    @Override
    public Page<Parfum> getAllParfumsParPage(int page, int size) {
return ParfumRepository.findAll(PageRequest.of(page, size));
}
	
}
