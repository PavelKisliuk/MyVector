package by.epam.javatraining.pavelkisliuk.controller;


import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import by.epam.javatraining.pavelkisliuk.model.logik.VectorChecker;
import by.epam.javatraining.pavelkisliuk.model.logik.VectorFinder;
import by.epam.javatraining.pavelkisliuk.model.logik.VectorSorterIncrease;
import by.epam.javatraining.pavelkisliuk.model.logik.VectorWorker;
import by.epam.javatraining.pavelkisliuk.util.VectorConsolePrinter;
import by.epam.javatraining.pavelkisliuk.util.VectorInitializer;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MyConsoleController {
	public static final int VECTOR_SIZE = 100;

	private Vector N;
	private int step;

	@FXML
	private TextArea mainTextArea;

	@FXML
	private Button nextStepButton;

	@FXML
	void nextStepOnAction(ActionEvent event) {
		mainTextArea.appendText("-----------------------------------------\n");
		switch (step++) {
			case 0:
				mainTextArea.appendText(String.format("%s%f%n", "Max element is ", VectorFinder.max(N)));
				break;
			case 1:
				mainTextArea.appendText(String.format("%s%f%n", "Min element is ", VectorFinder.min(N)));
				break;
			case 2:
				mainTextArea.appendText(String.format("%s%.3f%n", "Average is ", VectorWorker.averageArithmetic(N)));
				break;
			case 3:
				mainTextArea.appendText(String.format("%s%s%n", "Is sorted: ",
						VectorChecker.isSortedIncrease(N) ? "true" : "false"));
				break;
			case 4:
				VectorSorterIncrease sorter = new VectorSorterIncrease();
				sorter.quickSort(N);
				mainTextArea.appendText("Sorting: \n");
				mainTextArea.appendText(N.toString());
				VectorConsolePrinter.print(N);
				break;
			case 5:
				mainTextArea.appendText(String.format("%s%s%n", "Is sorted: ",
						VectorChecker.isSortedIncrease(N) ? "true" : "false"));
				break;
			default:
				mainTextArea.appendText("Finally!");
				nextStepButton.setDisable(true);
				break;
		}
	}

	@FXML
	void initialize() {
		mainTextArea.textProperty().addListener((ChangeListener<Object>) (observable, oldValue, newValue) ->
				mainTextArea.setScrollTop(Double.MAX_VALUE));

		N = new Vector(VECTOR_SIZE);
		VectorInitializer.init(N);
		step = 0;
		mainTextArea.appendText("Created Vector:\n");
		mainTextArea.appendText(N.toString());
		VectorConsolePrinter.print(N);
	}
}