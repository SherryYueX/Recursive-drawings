
public class TextViewer implements DrawingView{
	DrawingModel model = new DrawingModel();

	@Override
	public void update(DrawingModel m) {
		// TODO Auto-generated method stub
		model = m;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		if(model != null) {
			for(Shape s: model.getShapes()) {
				System.out.println(s.toString());
			}
		}
		
	}
	
}
